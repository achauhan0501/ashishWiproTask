package com.example.ashish.task;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u0012\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u001fH\u0016J&\u0010/\u001a\u00020%2\u0006\u0010.\u001a\u00020\u001f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u00101\u001a\u00020\u001fH\u0016J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020,H\u0014J\u0006\u00104\u001a\u00020%J\u0006\u00105\u001a\u00020%R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00066"}, d2 = {"Lcom/example/ashish/task/MainActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/example/ashish/task/presenter/GetDataInterface$View;", "()V", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "list", "Ljava/util/ArrayList;", "Lcom/example/ashish/task/model/RowData;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "presenter", "Lcom/example/ashish/task/presenter/PresenterLogic;", "getPresenter", "()Lcom/example/ashish/task/presenter/PresenterLogic;", "setPresenter", "(Lcom/example/ashish/task/presenter/PresenterLogic;)V", "snackbar", "Landroid/support/design/widget/Snackbar;", "getSnackbar", "()Landroid/support/design/widget/Snackbar;", "setSnackbar", "(Landroid/support/design/widget/Snackbar;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "initialise", "", "isNetworkAvailable", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGetDataFailure", "message", "onGetDataSuccess", "data", "heading", "onSaveInstanceState", "outState", "refresh", "showNoInternetSnackBar", "app_debug"})
public final class MainActivity extends android.support.v7.app.AppCompatActivity implements com.example.ashish.task.presenter.GetDataInterface.View {
    @org.jetbrains.annotations.Nullable()
    private com.example.ashish.task.presenter.PresenterLogic presenter;
    @org.jetbrains.annotations.Nullable()
    private android.support.v7.widget.LinearLayoutManager layoutManager;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.ashish.task.model.RowData> list;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    @org.jetbrains.annotations.Nullable()
    private android.support.design.widget.Snackbar snackbar;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.ashish.task.presenter.PresenterLogic getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.Nullable()
    com.example.ashish.task.presenter.PresenterLogic p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.support.v7.widget.LinearLayoutManager getLayoutManager() {
        return null;
    }
    
    public final void setLayoutManager(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.LinearLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.ashish.task.model.RowData> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.ashish.task.model.RowData> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.support.design.widget.Snackbar getSnackbar() {
        return null;
    }
    
    public final void setSnackbar(@org.jetbrains.annotations.Nullable()
    android.support.design.widget.Snackbar p0) {
    }
    
    @java.lang.Override()
    public void onGetDataSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.ashish.task.model.RowData> data, @org.jetbrains.annotations.NotNull()
    java.lang.String heading) {
    }
    
    @java.lang.Override()
    public void onGetDataFailure(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void refresh() {
    }
    
    public final void initialise() {
    }
    
    /**
     * * Show No Internet Snackbar
     */
    public final void showNoInternetSnackBar() {
    }
    
    public final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public MainActivity() {
        super();
    }
}