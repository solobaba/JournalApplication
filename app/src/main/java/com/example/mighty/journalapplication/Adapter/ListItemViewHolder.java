package com.example.mighty.journalapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mighty.journalapplication.MainActivity;
import com.example.mighty.journalapplication.R;
import com.example.mighty.journalapplication.model.ToDo;

import java.util.List;

public class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{

    ItemClickListesner itemClickListesner;
    TextView item_title, item_description;

    public ListItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

        item_title = (TextView) itemView.findViewById(R.id.item_title);
        item_description = (TextView) itemView.findViewById(R.id.item_description);
    }

    public void setItemClickListesner(ItemClickListesner itemClickListesner) {
        this.itemClickListesner = itemClickListesner;
    }

    @Override
    public void onClick(View view) {
        itemClickListesner.onClick(view, getAdapterPosition(), false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        contextMenu.setHeaderTitle("Select the action");
        contextMenu.add(0, 0, getAdapterPosition(), "DELETE");
    }

    public static class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder>{

        MainActivity mainActivity;
        List<ToDo> toDoList;

        public ListItemAdapter(MainActivity mainActivity, List<ToDo> toDoList) {
            this.mainActivity = mainActivity;
            this.toDoList = toDoList;
        }

        @Override
        public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mainActivity.getBaseContext());
            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new ListItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ListItemViewHolder holder, int position) {
            //Set data for item
            holder.item_title.setText(toDoList.get(position).getTitle());
            holder.item_description.setText(toDoList.get(position).getDescription());

            holder.setItemClickListesner(new ItemClickListesner() {
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    //When user select item, data will auto set for Edit Text View
                    mainActivity.title.setText(toDoList.get(position).getTitle());
                    mainActivity.description.setText(toDoList.get(position).getDescription());

                    mainActivity.isUpdate=true; //Set flag is update = true
                    mainActivity.idUpdate = toDoList.get(position).getId();
                }
            });
        }

        @Override
        public int getItemCount() {
            return toDoList.size();
        }
    }
}
