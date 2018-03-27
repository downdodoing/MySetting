package com.example.dengbijun.mythreadtest;

/**
 * Created by dengbijun on 18-3-20.
 */

public class MyLock {
    private boolean isLocked = false;
    private Thread mCurrentThread;

    private int mLockedCount;

    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        while (isLocked && mCurrentThread != currentThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mLockedCount++;
        mCurrentThread = currentThread;
        isLocked = true;
    }

    public synchronized void unLock() {
        if (Thread.currentThread() == mCurrentThread) {
            mLockedCount--;
        }

        if (0 == mLockedCount) {
            isLocked = false;
            notify();
        }
    }
}
