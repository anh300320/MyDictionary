package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import activities.HashtagActivity;
import com.example.mydictionary.ListTags;
import com.example.mydictionary.R;

import adapters.TagListAdapter;
import interfaces.OnItemClickListener;

public class VocabularyFragment extends Fragment {

    RecyclerView recyclerView;
    TagListAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vocab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.fragment_vocab_listtags);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new TagListAdapter(ListTags.getAll());
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), HashtagActivity.class);
                intent.putExtra("hashtag", ListTags.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        ListTags.readData(getContext());
        mAdapter = new TagListAdapter(ListTags.getAll());
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), HashtagActivity.class);
                intent.putExtra("hashtag", ListTags.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
        super.onResume();
        super.onResume();
    }
}