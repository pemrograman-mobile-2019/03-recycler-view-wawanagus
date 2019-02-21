package e.mrjiro.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import e.mrjiro.myapplication.R;
import e.mrjiro.myapplication.models.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    //atribut
    private List<Contact> mContact;

    //constructor
    public ContactsAdapter(List<Contact> mContact){
        this.mContact = mContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //menghubungkan item_contact.xml ke adapter
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.activity_contact,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //menghububgkan / mensetting nilai maising item
        Contact itemContact = mContact.get(i);
        TextView textView = viewHolder.nameTextView;
        textView.setText(itemContact.getName());

        Button buttonContact = viewHolder.messageButton;
        buttonContact.setText(itemContact.isOnline()? "Message" : "Offline");
        buttonContact.setEnabled(itemContact.isOnline());
    }

    @Override
    public int getItemCount() {
        //mengembalikan panjang data
        return mContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private Button messageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);
            messageButton = itemView.findViewById(R.id.message_button);
        }
    }
}
