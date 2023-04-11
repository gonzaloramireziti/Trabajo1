package com.example.trabajo1;

import android.content.Context;
import android.content.Intent;

public class Navigator {

    public static void navegarTo (Context origen, Class<?> destino){


        Intent intentGo = new Intent(origen,destino);
        origen.startActivity(intentGo);

    }


}
