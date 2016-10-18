package me.yifeiyuan.understandingandroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupItems();


        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(mAdapter);

    }

    private void setupItems() {
        mItems.add(new AndroidItem("IPC", "ipc"));
        mItems.add(new AndroidItem("Dagger2", "dagger2"));
    }

    private List<AndroidItem> mItems = new ArrayList<>();

    private RecyclerView.Adapter<VH> mAdapter = new RecyclerView.Adapter<VH>() {

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            return new VH(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {

            final AndroidItem item = mItems.get(position);
            holder.title.setText(item.title);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        Intent intent = new Intent(item.action);
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        // do nothing
                        Toast.makeText(MainActivity.this,"No Activity",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

    };


    private static class VH extends RecyclerView.ViewHolder {

        public TextView title;

        VH(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }

    }
}
