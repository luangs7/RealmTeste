package br.com.luan.realmteste;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.luan.realmteste.model.ModeloObj;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView textView;
    private android.widget.Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.button);
        this.textView = (TextView) findViewById(R.id.textView);

        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder(this).build();
        final Realm realm = Realm.getInstance(realmConfig);

        // Cria um novo
        final ModeloObj newTask = new ModeloObj();
        newTask.setTaskId(9); // Use um ID válido
        newTask.setDescription("New task description");
        newTask.setChecked(false);

        realm.beginTransaction();
        realm.copyToRealm(newTask);
        realm.commitTransaction();

        ModeloObj nObj = realm.where(ModeloObj.class).findFirst();

        textView.setText(nObj.getDescription());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newTask.setDescription("Mudou");
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(newTask);
                realm.commitTransaction();

                ModeloObj nObj = realm.where(ModeloObj.class).findFirst();
                textView.setText(nObj.getDescription());

            }
        });

    }
}
