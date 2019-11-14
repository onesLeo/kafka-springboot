package com.allianz.kafkatesting.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class MyCallBackImpl implements ListenableFutureCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyCallBackImpl.class);
    @Override
    public void onFailure(Throwable ex) {
//        LOGGER.error("ERROR HAPPENED ",ex);
        try {
            throw ex;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void onSuccess(Object result) {
        LOGGER.info("SUCCESS SENDING MESSAGE");
    }
}
