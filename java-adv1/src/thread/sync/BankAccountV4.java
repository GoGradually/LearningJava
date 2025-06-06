package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV4 implements BankAccount{

    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initBalance){
        this.balance = initBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());
        lock.lock();

        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if(balance<amount){
                log("[검증 실패] 출금액: "+ amount + ", 잔액: " + balance);
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000);
            balance -= amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }


        log("거래 종료");
        return true;
    }


    @Override
    public synchronized int getBalance() {
        lock.lock();
        try {
            return balance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
