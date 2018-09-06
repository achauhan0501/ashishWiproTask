package com.example.ashish.task.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/example/ashish/task/presenter/GetDataInterface;", "", "Interactor", "Presenter", "View", "onGetDataListener", "app_debug"})
public abstract interface GetDataInterface {
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/ashish/task/presenter/GetDataInterface$View;", "", "onGetDataFailure", "", "message", "", "onGetDataSuccess", "list", "Ljava/util/ArrayList;", "Lcom/example/ashish/task/model/RowData;", "title", "app_debug"})
    public static abstract interface View {
        
        public abstract void onGetDataSuccess(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.example.ashish.task.model.RowData> list, @org.jetbrains.annotations.NotNull()
        java.lang.String title);
        
        public abstract void onGetDataFailure(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/ashish/task/presenter/GetDataInterface$Presenter;", "", "getDataFromURL", "", "context", "Landroid/content/Context;", "app_debug"})
    public static abstract interface Presenter {
        
        public abstract void getDataFromURL(@org.jetbrains.annotations.NotNull()
        android.content.Context context);
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/ashish/task/presenter/GetDataInterface$Interactor;", "", "initRetrofitCall", "", "context", "Landroid/content/Context;", "app_debug"})
    public static abstract interface Interactor {
        
        public abstract void initRetrofitCall(@org.jetbrains.annotations.NotNull()
        android.content.Context context);
    }
    
    @kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/ashish/task/presenter/GetDataInterface$onGetDataListener;", "", "onFailure", "", "message", "", "onSuccess", "list", "Ljava/util/ArrayList;", "Lcom/example/ashish/task/model/RowData;", "title", "app_debug"})
    public static abstract interface onGetDataListener {
        
        public abstract void onSuccess(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.example.ashish.task.model.RowData> list, @org.jetbrains.annotations.NotNull()
        java.lang.String title);
        
        public abstract void onFailure(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
    }
}