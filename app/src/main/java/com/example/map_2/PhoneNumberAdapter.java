package com.example.map_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import java.util.List;


public class PhoneNumberAdapter extends RecyclerView.Adapter<PhoneNumberAdapter.ViewHolder> {

    private List<PhoneNumber> phoneNumbers;
    private Context context;
    private static final int CALL_PHONE_PERMISSION_REQUEST_CODE = 0;


    public PhoneNumberAdapter(List<PhoneNumber> phoneNumbers, Context context) {
        this.phoneNumbers = phoneNumbers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_phone_number_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhoneNumber phoneNumber = phoneNumbers.get(position);
        holder.phoneNumberName.setText(phoneNumber.getName());
        holder.phoneNumberText.setText(phoneNumber.getNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(phoneNumber.getNumber());
            }
        });
    }

    private void dialPhoneNumber(String phoneNumber) {
        Uri number = Uri.parse("tel:" + phoneNumber);
        Intent dialIntent = new Intent(Intent.ACTION_CALL, number);
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted, initiate the call
            if (dialIntent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(dialIntent);
            }
        } else {
            // Request the CALL_PHONE permission
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, CALL_PHONE_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public int getItemCount() {
        return phoneNumbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView phoneNumberIcon;
        TextView phoneNumberName;
        TextView phoneNumberText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneNumberIcon = itemView.findViewById(R.id.phone_number_icon);
            phoneNumberName = itemView.findViewById(R.id.phone_number_name);
            phoneNumberText = itemView.findViewById(R.id.phone_number_text);
        }
    }
}
