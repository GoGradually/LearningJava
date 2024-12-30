package hello.externalread2.pay;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdPayClient implements PayClient{
    @Override
    public void pay(int money) {
        log.info("운영 결제 money={}", money);
    }
}
