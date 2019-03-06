package e.taufan.customerapps.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import e.taufan.customerapps.EditActivity;
import e.taufan.customerapps.R;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    ImageButton imgButton;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        imgButton = view.findViewById(R.id.imgButton_edit_profile);
        imgButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgButton_edit_profile:
                Intent intentEdit = new Intent(getContext(), EditActivity.class);
                startActivity(intentEdit);
                break;

        }
    }
}
