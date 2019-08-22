package co.id.digitalent.rumahadat.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import co.id.digitalent.rumahadat.Act.DetailActivity;
import co.id.digitalent.rumahadat.Util.Base;
import co.id.digitalent.rumahadat.Model.RumahAdat;
import co.id.digitalent.rumahadat.R;

public class ListRumahAdapter extends RecyclerView.Adapter<ListRumahAdapter.ListRumahHolder> {

    private ArrayList<RumahAdat> listRumahAdat;

    public ListRumahAdapter(ArrayList<RumahAdat> list) {
        this.listRumahAdat = list;
    }

    @NonNull
    @Override
    public ListRumahHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ListRumahHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListRumahHolder listRumahHolder, int i) {
        final RumahAdat rumahAdat = listRumahAdat.get(i);
        Glide.with(listRumahHolder.itemView.getContext())
                .load(rumahAdat.getGambar())
                .apply(new RequestOptions().override(55, 55))
                .into(listRumahHolder.imgPhoto);

        listRumahHolder.tvName.setText(rumahAdat.getNamaRumah());
        listRumahHolder.tvFrom.setText(rumahAdat.getDaerah());

        listRumahHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetail = new Intent(v.getContext(), DetailActivity.class);
                intentDetail.putExtra(Base.EXTRA_NAME, rumahAdat.getNamaRumah());
                intentDetail.putExtra(Base.EXTRA_DESCRIPTION, rumahAdat.getDeskripsi());
                intentDetail.putExtra(Base.EXTRA_FROM, rumahAdat.getDaerah());
                intentDetail.putExtra(Base.EXTRA_IMAGE, rumahAdat.getGambar());
                v.getContext().startActivity(intentDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listRumahAdat.size();
    }

    public class ListRumahHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        public ListRumahHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
        }
    }
}
