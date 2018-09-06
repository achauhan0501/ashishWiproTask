package com.example.ashish.task.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/ashish/task/presenter/PresenterLogic;", "Lcom/example/ashish/task/presenter/GetDataInterface$Presenter;", "Lcom/example/ashish/task/presenter/GetDataInterface$onGetDataListener;", "mGetDataView", "Lcom/example/ashish/task/presenter/GetDataInterface$View;", "(Lcom/example/ashish/task/presenter/GetDataInterface$View;)V", "getMGetDataView", "()Lcom/example/ashish/task/presenter/GetDataInterface$View;", "setMGetDataView", "mIntractor", "Lcom/example/ashish/task/presenter/Intractor;", "getDataFromURL", "", "context", "Landroid/content/Context;", "onFailure", "message", "", "onSuccess", "list", "Ljava/util/ArrayList;", "Lcom/example/ashish/task/model/RowData;", "title", "app_debug"})
public final class PresenterLogic implements com.example.ashish.task.presenter.GetDataInterface.Presenter, com.example.ashish.task.presenter.GetDataInterface.onGetDataListener {
    private final com.example.ashish.task.presenter.Intractor mIntractor = null;
    @org.jetbrains.annotations.NotNull()
    private com.example.ashish.task.presenter.GetDataInterface.View mGetDataView;
    
    @java.lang.Override()
    public void getDataFromURL(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.ashish.task.model.RowData> list, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @java.lang.Override()
    public void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ashish.task.presenter.GetDataInterface.View getMGetDataView() {
        return null;
    }
    
    public final void setMGetDataView(@org.jetbrains.annotations.NotNull()
    com.example.ashish.task.presenter.GetDataInterface.View p0) {
    }
    
    public PresenterLogic(@org.jetbrains.annotations.NotNull()
    com.example.ashish.task.presenter.GetDataInterface.View mGetDataView) {
        super();
    }
}