package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member = em.find(Member.class, 100L);
            member.setName("zzzzz");

            em.clear();

            Member member2 = em.find(Member.class, 100L);

            System.out.println("member == member2 ? : "+(member == member2));
            System.out.println("member2.getId() = " + member2.getId());
            System.out.println("member2.getName() = " + member2.getName());
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();

        }
        emf.close();
    }
}
