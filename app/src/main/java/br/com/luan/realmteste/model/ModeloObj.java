package br.com.luan.realmteste.model;

import io.realm.RealmModel;
import io.realm.annotations.Ignore;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Dev_Maker on 07/02/2017.
 */

@RealmClass
public class ModeloObj implements RealmModel{

//    @required indica que o campo não pode ser nulo;
//    @Index indica que o campo será indexado;
//    @PrimaryKey   indica uma chave primária;
//    @Ignore  indica que o campo não será persistido em disco.

    @PrimaryKey
    private int taskId;
    private String description;
    private boolean checked;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }



}
