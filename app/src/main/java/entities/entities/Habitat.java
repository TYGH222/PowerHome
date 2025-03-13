package entities.entities;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Habitat {
    String urlString = "http://10.0.2.2/powerhome_server/getHabitats.php";

    public int id;
    public int floor;
    public double area;
    public User user;
    public List<Appliance> appliances;

    public Habitat() {
        appliances = new ArrayList<>();
    }

    public Habitat(int id, int floor, double area) {
        this.id = id;
        this.floor = floor;
        this.area = area;
        appliances = new ArrayList<>();
    }

//    public static Habitat getFromJson(String json){
//        Gson gson = new Gson();
//        Habitat obj;
//        String urlString = "http://10.0.2.2/powerhome_server/getHabitats.php";
//        Ion.with(this)
//                .load(urlString)
//                .asString()
//                .withResponse()
//                .setCallback(new FutureCallback<Response<String>>() {
//                    @Override
//                    public void onCompleted(Exception e,Response<String> response){
//                        if(e == null && response != null){
//                            obj = gson.fromJson(json, Habitat.class);
//                        }
//                    }
//                });
//
//
//        return obj;
//    }
    public static List<Habitat> getListFromJson(String json){


        Gson gson = new Gson();
        Type type = new TypeToken<List<Habitat>>(){}.getType();
        List<Habitat> list = gson.fromJson(json, type);
        return list;
    }
}
