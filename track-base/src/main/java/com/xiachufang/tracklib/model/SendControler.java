package com.xiachufang.tracklib.model;


/**
 * creator huangyong
 * createTime 2018/12/6 下午12:01
 * path com.xiachufang.tracklib.model
 * description:
 */
public class SendControler implements ISendControl{

    //当满足连续操作大于100条,就进行上传服务
    private static int eventNum = 0;

    private static int eventQueneSize = 0;

    @Override
    public boolean shouldSend() {

        if (eventNum>=100){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 内存操作计数递增
     */
    @Override
    public void inCrease() {
        eventNum+=1;
    }
    /**
     * 成功发送一条，队列正在发送计数递减
     */
    @Override
    public void deCrease() {
        eventQueneSize-=1;
    }

    /**
     * 发送队列发送完毕，数量重置
     */
    @Override
    public void reset() {
        eventQueneSize=0;
    }

    @Override
    public void initTaskSize(int size) {
        eventNum=size;
    }

    @Override
    public int getQueneSize() {
        return eventQueneSize;
    }

    @Override
    public void deCreaseEventQueneNum(int size) {
        eventQueneSize = size;
        eventNum-=size;
    }

}
