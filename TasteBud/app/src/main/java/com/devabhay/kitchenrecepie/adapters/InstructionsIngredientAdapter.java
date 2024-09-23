package com.devabhay.kitchenrecepie.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devabhay.kitchenrecepie.R;
import com.devabhay.kitchenrecepie.models.Ingredient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstructionsIngredientAdapter extends RecyclerView.Adapter<InstructionIngredientViewHolder>{

    Context context;
    List<Ingredient> list;

    public InstructionsIngredientAdapter(Context context, List<Ingredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InstructionIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionIngredientViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instruction_step_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionIngredientViewHolder holder, int position) {
        holder.textView_instruction_step_item.setText(list.get(position).name);
        holder.textView_instruction_step_item.setSelected(true);
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/" + list.get(position).image)
                .into(holder.imageView_instruction_step_item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class InstructionIngredientViewHolder extends RecyclerView.ViewHolder {

    TextView textView_instruction_step_item;
    ImageView imageView_instruction_step_item;

    public InstructionIngredientViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView_instruction_step_item = itemView.findViewById(R.id.imageView_instruction_step_item);
        textView_instruction_step_item = itemView.findViewById(R.id.textView_instruction_step_item);
    }
}
