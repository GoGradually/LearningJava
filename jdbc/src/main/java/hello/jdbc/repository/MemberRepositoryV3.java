package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;


/**
 * 트랜잭션 - 트랜잭션 매니저
 * DataSourceUtils.getConnection()
 * DataSourceUtils.releaseConnection()
 */
@Slf4j
public class MemberRepositoryV3 {

    private final DataSource dataSource;

    public MemberRepositoryV3(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Member save(Member member) throws SQLException {
        // Save 함수의 표준 SQL 정의
        // ? 을 통한 파라미터 바인딩 사용
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            //커넥션 획득
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // 파라미터 바인딩 지정
            // 파라미터에 적절한 자료형을 지정하여 입력받게 해줌.
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            //SQL 실행
            pstmt.executeUpdate();
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            // 반드시 커넥션을 다시 닫아줘야 함.
            // 리소스 낭비 방지
            pstmt.close();
            con.close();
        }
    }

    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            // select 문의 경우 값의 갱신이 아닌 값의 탐색이기 때문에, executeQuery() 메소드 사용
            rs = pstmt.executeQuery();
            // rs.next () 는 반드시 한번 호출해야 한다.
            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else {
                throw new NoSuchElementException("member not found memberId= " + memberId);
            }
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }


    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money=? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            //커넥션 획득
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // 파라미터 바인딩 지정
            // 파라미터에 적절한 자료형을 지정하여 입력받게 해줌.
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId);
            //SQL 실행
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize={}", resultSize);
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            // 반드시 커넥션을 다시 닫아줘야 함.
            // 리소스 낭비 방지
            close(con, pstmt, null);
        }
    }


    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id=?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            //커넥션 획득
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // 파라미터 바인딩 지정
            // 파라미터에 적절한 자료형을 지정하여 입력받게 해줌.
            pstmt.setString(1, memberId);
            //SQL 실행
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            // 반드시 커넥션을 다시 닫아줘야 함.
            // 리소스 낭비 방지
            pstmt.close();
            con.close();
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        //주의! 트랜잭션 동기화 사용하려면 커넥션 생성과 삭제 시 DataSourceUtils 를 사용해야 한다!
        DataSourceUtils.releaseConnection(con, dataSource);
    }

    private Connection getConnection() throws SQLException {
        //주의! 트랜잭션 동기화 사용하려면 커넥션 생성과 삭제 시 DataSourceUtils 를 사용해야 한다!
        Connection con = DataSourceUtils.getConnection(dataSource);
        log.info("get connection = {}, class = {}", con, con.getClass());
        return con;
    }
}
