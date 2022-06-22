package com.example.myapp06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private final ArrayList<Person> personArrayList;
    private PersonListener personListener;

    public PersonAdapter(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public void setPersonListener(PersonListener personListener) {
        this.personListener = personListener;
    }

    // getItem 만큼 ViewHolder 생성, 객체 바인딩
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // recylcer_person_item.xml inflate
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // recylcer_person_item.xml 레이아웃을 가진 View 객체 생성
        View view = inflater.inflate(R.layout.recycler_person_item, parent, false);

        // ViewHolder 객체가 잡고 있을 객체의 바인딩
        PersonAdapter.ViewHolder viewHolder = new PersonAdapter.ViewHolder(view);
        return viewHolder;
    }


    // view holder 레이아웃 데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Person person = personArrayList.get(position);
        holder.imageView.setImageResource(person.getImgId());
        holder.tvName.setText(person.getName());
        holder.tvTel.setText(person.getTel());

        /*bind 할때 직접 구현*/
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), holder.getAdapterPosition() + " on click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                Toast.makeText(view.getContext(), holder.getAdapterPosition() + " long click", Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }


    public Person getItem(int position) {
        Person person = personArrayList.get(position);
        return person;
    }

    public void removeItem(int position) {
        personArrayList.remove(position);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName, tvTel;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvTel = itemView.findViewById(R.id.tvTel);

            /* holder에 바로 구현*/
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), tvName.getText() + " and " + tvTel.getText(), Toast.LENGTH_LONG).show();
//                }
//            });
//
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    personArrayList.remove(getAdapterPosition());
//                    notifyDataSetChanged();
//                    return false;
//
//                }
//            });

            ////// interface
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    personListener.onItemClick(position);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    personListener.onItemLongClick(position);
                    return false;
                }
            });


        }


    }

}