package galliano.android.seccion_03.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import galliano.android.seccion_03.R;
import galliano.android.seccion_03.models.PersonageVo;
import galliano.android.seccion_03.utilities.OnClickListener;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<PersonageVo> personages;
    private final int layout;
    private static OnClickListener listener;

    public MyAdapter (List<PersonageVo> personages, int layout){
        this.personages = personages;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v,layout);
        return vh;
    }

    public void setOnItemClickListener (OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(personages.get(position),layout);
    }

    @Override
    public int getItemCount() {
        return personages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textInfo;
        private final ImageView photo;

        public ViewHolder( View itemView, int layout) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.idName);
            if(layout==R.layout.recycler_view_item){
                this.textInfo = (TextView) itemView.findViewById(R.id.idInfo);
            }else{
                this.textInfo=null;
            }
            this.photo = (ImageView) itemView.findViewById(R.id.idImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getBindingAdapterPosition(),view);
                }
            });
        }

        public void bind(final PersonageVo personage, int layout){
            textViewName.setText(personage.getName());
            if(layout==R.layout.recycler_view_item){
                textInfo.setText(personage.getInfo());
            }
            photo.setImageResource(personage.getPhoto());
        }
    }
}
