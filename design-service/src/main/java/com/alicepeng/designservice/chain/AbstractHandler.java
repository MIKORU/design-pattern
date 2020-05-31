package com.alicepeng.designservice.chain;

public abstract class AbstractHandler {
    protected AbstractHandler nextHandle;

    /**
     * 设置下一步处理方式
     * @param nextHandle
     * @return
     */
    public AbstractHandler setNextStep(AbstractHandler nextHandle){
        this.nextHandle = nextHandle;
        return this.nextHandle;
    }

    public AbstractHandler getNextHandle(){
        return this.nextHandle;
    }

    /**
     * 实际处理方法
     * @param request
     */
    public abstract void process(AbstractHandler request);


}
