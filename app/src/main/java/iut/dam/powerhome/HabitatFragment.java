package iut.dam.powerhome;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;


public class HabitatFragment extends Fragment {
    private RecyclerView recyclerView;
    String[] NomHabitat = {
            "GAETAN LECLAIR", "CEDRIC BOUDET",
            "GAYLORD THIBODEAUX", "ADAM JACQUINOT",
            "ABEL FRESNEL"
    };
    ArrayList<ModeleHabitat> modeleHabitats = new ArrayList<>();

    boolean[][] equipement = {
            {true, true, true, true},
            {true, false, false, false},
            {false, true, false, true},
            {true, true, false, true},
            {false, true, false, false}
    };

    int[] etage = {1,1,2,3,3};


    public HabitatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_habitat, container, false);
        getActivity().setTitle("Habitats fragment");
        recyclerView = view.findViewById(R.id.listHabitats);

        setRecycleView();
        AdapteurHabitat adapteur = new AdapteurHabitat(getContext(), modeleHabitats);
        recyclerView.setAdapter(adapteur);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        getRemoteHabitats();
        return view;
    }

    private void setRecycleView( ) {
        for (int i = 0; i < NomHabitat.length; i++) {
            modeleHabitats.add(
                    new ModeleHabitat(NomHabitat[i], equipement[i],etage[i] ));

        }
    }


    public void getRemoteHabitats() {
        String urlString = "http://10.0.2.2/powerhome_server/getHabitats.php";
        Ion.with(this)
                .load(urlString)
                .asString()
                .withResponse()
                .setCallback(new FutureCallback<Response<String>>() {
                    @Override
                    public void onCompleted(Exception e,Response<String> response){
                        if(e == null && response != null){
                            Log.d(TAG, "Http code: " + response.getHeaders().code());
                            Log.d(TAG, "Result: " + response.getResult());
                        }
                    }
                });
    }


}


