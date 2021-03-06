package a1221.org.il.hatsalaquestionaire.adapters;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import a1221.org.il.hatsalaquestionaire.R;
import a1221.org.il.hatsalaquestionaire.entities.Language;

public class LanguageRecyclerAdapter extends RecyclerView.Adapter<LanguageRecyclerAdapter.ListViewHolder> {
    private static final String TAG = "LanguageRecyclerAdapter";
    private Context mContext;
    SortedList<Language> languages = new SortedList<>(Language.class, new SortedList.Callback<Language>() {

        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }

        @Override
        public int compare(Language a, Language b) {
            return Integer.compare(a.getSortID(),b.getSortID());
        }

        @Override
        public boolean areContentsTheSame(Language oldItem, Language newItem) {
            return oldItem.getLanguage().equals(newItem.getLanguage());
        }

        @Override
        public boolean areItemsTheSame(Language item1, Language item2) {
            return item1.get_ID() == item2.get_ID();
        }
    });





    public LanguageRecyclerAdapter(Context mContext) {
        //this.questions = questions;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((languages != null) && (languages.size() != 0) ? languages.size() : 0);

    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {
        // Called by the layout manager when it wants new data in an existing row


        Log.d(TAG, "onBindViewHolder: " + languages.get(position).getLanguage() + " --> " + position);
        holder.title.setText(languages.get(position).getLanguage());


    }

    public void addItem(Language language) {
        languages.add(language);
        notifyItemInserted(languages.size());
    }

    public void removeItem(int position) {
        languages.remove(languages.get(position));
        notifyItemRemoved(position);
    }




    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_item, parent, false);
        return new ListViewHolder(view);
    }


    public void loadNewData(SortedList<Language> newLanguages) {
        this.languages = newLanguages;
        notifyDataSetChanged();
    }


    public Language getLanguage(int position) {
        return ((languages != null) && (languages.size() != 0) ? languages.get(position) : null);
    }


    static class ListViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ListViewHolder";
        CardView cardItemLayout;
        TextView title;

        public ListViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "ListViewHolder: starts");
            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.listitem_name);
        }
    }

    public void add(Language model) {
        languages.add(model);
    }

    public void remove(Language model) {
        languages.remove(model);
    }

    public void add(List<Language> models) {
        languages.addAll(models);
    }

    public void remove(List<Language> models) {
        languages.beginBatchedUpdates();
        for (Language  model : models) {
            languages.remove(model);
        }
        languages.endBatchedUpdates();
    }

    public void addList(List<Language> models) {
        languages.addAll(models);
    }

    public void replaceAll(List<Language> models) {
        languages.beginBatchedUpdates();
        for (int i = languages.size() - 1; i >= 0; i--) {
            final Language model = languages.get(i);
            if (!models.contains(model)) {
                languages.remove(model);
            }
        }
        languages.addAll(models);
        languages.endBatchedUpdates();
    }
}
