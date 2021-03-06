package fr.insalyon.pi.tabmaster.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import fr.insalyon.pi.tabmaster.R;
import fr.insalyon.pi.tabmaster.models.TabRessource;

/**
 * Created by Ugo on 31/05/2016.
 */
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class TabAdapter extends RecyclerView.Adapter<TabAdapter.ViewHolder> {

    // Store a member variable for the tabs
    private List<TabRessource> mTabs;

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Your holder should contain a member variable for any view that will be set as you render a rowaccess
        private TextView titleTV;
        private TextView authorTV;
        private ImageButton openBtn;

        public ViewHolder(View itemView) {

            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            // Define click listener for the ViewHolder's View.
            /*
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            */
            titleTV = (TextView) itemView.findViewById(R.id.titleTV);
            authorTV = (TextView) itemView.findViewById(R.id.authorTV);
            openBtn = (ImageButton) itemView.findViewById(R.id.openButton);
        }
    }

    // Pass in the tab array into the constructor
    public TabAdapter(List<TabRessource> tabs) {
        Log.d("TabAdapter", "Getting tabs list...");
        Log.d("TabAdapter", "Got tab list from fragment : " + tabs.get(12).getAuthor());
        mTabs = tabs;
        Log.d("TabAdapter", "PASSED : tabs list caught : " + mTabs.get(12).getAuthor());
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View tabView = inflater.inflate(R.layout.tab_lib_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(tabView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(TabAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        TabRessource tab = mTabs.get(position);

        // Set item views based on the data model
        TextView title = viewHolder.titleTV;
        title.setText(tab.getTitle());

        TextView author = viewHolder.authorTV;
        author.setText(tab.getAuthor());

        ImageButton openButton = viewHolder.openBtn;
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return mTabs.size();
    }
}
