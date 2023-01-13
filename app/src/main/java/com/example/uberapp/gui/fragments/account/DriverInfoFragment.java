package com.example.uberapp.gui.fragments.account;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.uberapp.R;
import com.example.uberapp.core.tools.UserMockup;

public class DriverInfoFragment extends Fragment {


    public DriverInfoFragment() {
        // Required empty public constructor
    }
    public static DriverInfoFragment newInstance() {
        DriverInfoFragment fragment = new DriverInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupEditText(View view,String type,String value){
        EditText editText=view.findViewById(R.id.editTextTextPersonName);
        ImageButton edit= view.findViewById(R.id.editBtnDriverName);
        ImageButton accept= view.findViewById(R.id.checkBtnDriverName);
        ImageButton cancel= view.findViewById(R.id.cancelBtnDriverName);
        editText.setText(value);
        switch(type) {
            case "phone":
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case "email":
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            default:
        }



        EditText finalEditText = editText;
        ImageButton finalEdit = edit;
        ImageButton finalAccept = accept;
        ImageButton finalCancel = cancel;
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalEditText.setBackgroundTintList( ColorStateList.valueOf(Color.WHITE) );
                finalEditText.setEnabled(true);
                finalEditText.setTextColor(getResources().getColor(R.color.dark_gray));
                finalEdit.setVisibility(View.INVISIBLE);
                finalAccept.setVisibility(View.VISIBLE);
                finalCancel.setVisibility(View.VISIBLE);
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalEditText.setBackgroundTintList( ColorStateList.valueOf(Color.TRANSPARENT ) );
                finalEditText.setEnabled(false);
                finalEditText.setTextColor(getResources().getColor(R.color.dark_gray_pewter));
                finalEdit.setVisibility(View.VISIBLE);
                finalAccept.setVisibility(View.INVISIBLE);
                finalCancel.setVisibility(View.INVISIBLE);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalEditText.setBackgroundTintList( ColorStateList.valueOf(getResources().getColor(R.color.pewter_dark_blue)) );
                finalEditText.setEnabled(false);
                finalEditText.setTextColor(getResources().getColor(R.color.dark_gray_pewter));
                finalEdit.setVisibility(View.VISIBLE);
                finalAccept.setVisibility(View.INVISIBLE);
                finalCancel.setVisibility(View.INVISIBLE);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_driver_info, container, false);
        /*User user = UserMockup.getUsers().get(1);

        setupEditText(view.findViewById(R.id.nameContainerDriver),"name",user.getName());
        setupEditText(view.findViewById(R.id.lastNameContainerDriver),"lastname",user.getLastName());
        setupEditText(view.findViewById(R.id.phoneContainerDriver),"phone",user.getPhoneNumber());
        setupEditText(view.findViewById(R.id.emailContainerDriver),"email",user.getEmail());
        setupEditText(view.findViewById(R.id.addressContainerDriver),"email",user.getAddress());*/


        ActivityResultLauncher<PickVisualMediaRequest> pickDriversLicnece =
                registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                    // Callback is invoked after the user selects a media item or closes the
                    // photo picker.
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: " + uri);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                });

       /* Button buttonDriversLicence = view.findViewById(R.id.buttonPickDriversLicence);
        buttonDriversLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDriversLicnece.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                        .build());
            }
        });*/

        ActivityResultLauncher<PickVisualMediaRequest> pickRegistrationLicence =
                registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                    // Callback is invoked after the user selects a media item or closes the
                    // photo picker.
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: " + uri);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                });

        Button buttonRegistrationLicence = view.findViewById(R.id.buttonPickRegistrationLicence);
        /*buttonRegistrationLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickRegistrationLicence.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                        .build());
            }
        });*/
        return view;
    }
}