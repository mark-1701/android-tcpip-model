package com.example.modelotcp_ip_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    TextView textViewLayer;
    ImageButton imageButtonPC1, imageButtonPC2, imageButtonRouter;
    InformationSingleton infSingleton = InformationSingleton.getInstance();
    Layer mainLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbarMain));
        //getSupportActionBar().setTitle("Modelo TCP/IP"); // Establecer el título como una cadena vacía

        imageButtonPC1 = findViewById(R.id.imageButtonPC1);
        imageButtonPC2 = findViewById(R.id.imageButtonPC2);
        imageButtonRouter = findViewById(R.id.imageButtonRouter);
        textViewLayer = findViewById(R.id.textViewLayer);

        /*VALORES INICIALES*/
        infSingleton.setLayerLevel(1);
        mainLayer = infSingleton.getLayer1();
        printLayerLevel();

        imageButtonPC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeviceAlertDialog(mainLayer, 0);
                showMethodAlertDialog();
            }
        });

        imageButtonPC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeviceAlertDialog(mainLayer, 1);
                showMethodAlertDialog();
            }
        });

        imageButtonRouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeviceAlertDialog(mainLayer, 2);
                showMethodAlertDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu miMenu) {
        getMenuInflater().inflate(R.menu.main_menu, miMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();
        if (id == R.id.librery) {
            showLayerAlertDialog();
            return true;
        }
        if (id == R.id.protocols) {
            showProtocolsAlertDialog();
            return true;
        }
        if (id == R.id.layer1) {
            infSingleton.setLayerLevel(1);
            mainLayer = infSingleton.getLayer1();
            printLayerLevel();
            return true;
        }
        if (id == R.id.layer2) {
            infSingleton.setLayerLevel(2);
            mainLayer = infSingleton.getLayer2();
            printLayerLevel();
            return true;
        }
        if (id == R.id.layer3) {
            infSingleton.setLayerLevel(3);
            mainLayer = infSingleton.getLayer3();
            printLayerLevel();
            return true;
        }
        if (id == R.id.layer4) {
            infSingleton.setLayerLevel(4);
            mainLayer = infSingleton.getLayer4();
            printLayerLevel();
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }

    public void printLayerLevel() {
        textViewLayer.setText("Nivel de capa: " + infSingleton.getLayerLevel());
        Toast.makeText(MainActivity.this, "Nivel de Capa " + infSingleton.getLayerLevel(), Toast.LENGTH_SHORT).show();
    }

    public void showLayerAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Configura el título y el mensaje del cuadro de diálogo
        builder.setTitle(mainLayer.getTitle());
        builder.setMessage(mainLayer.getDescription());

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showProtocolsAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Configura el título y el mensaje del cuadro de diálogo
        builder.setTitle("Protocolos");
        builder.setMessage(mainLayer.getProtocols());

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showMethodAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Método");
        builder.setMessage(mainLayer.getMethod());
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showDeviceAlertDialog(Layer layer, int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinkedList<Device> devices = layer.getDevices();

        builder.setTitle(devices.get(id).getName());
        builder.setMessage(devices.get(id).getDescription());

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}