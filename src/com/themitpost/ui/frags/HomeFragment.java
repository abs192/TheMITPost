package com.themitpost.ui.frags;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themitpost.R;
import com.themitpost.data.Article;
import com.themitpost.data.Author;
import com.themitpost.ui.adapters.HomeRecyclerViewAdapter;
import com.themitpost.ui.adapters.HomeRecyclerViewAdapter.ViewHolder;

public class HomeFragment extends Fragment {

	public HomeFragment() {
		super();
	}

	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter<ViewHolder> mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	private Article featuredArticle;
	private List<Article> articles;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_home, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {

		getActivity().setTitle("Top Stories");
		initDummyArticles();
		mRecyclerView = (RecyclerView) getView().findViewById(
				R.id.recycler_view);
		mRecyclerView.setHasFixedSize(false);

		mLayoutManager = new LinearLayoutManager(this.getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);

		mAdapter = new HomeRecyclerViewAdapter(articles);
		mRecyclerView.setAdapter(mAdapter);
	}

	public void initDummyArticles() {
		Author featuredArticleAuthor = new Author("Amit Shah/Staff Writer", 0,
				"");
		featuredArticle = new Article(
				"Suspects in Baltimore Shooting arrested",
				"Six cops involved in the murder of a boy were taken into custody on Friday",
				"", "news1.jpg", featuredArticleAuthor, null);
		featuredArticle.setFeatured(true);
		Author author1 = new Author("Sagnik Basu/Staff Writer", 0, "");
		Article a1 = new Article(
				"",
				"Isis grows in power incessantly as it’s reign of tyranny, oppression and cruelty continues.",
				"", "news4.jpg", author1, null);
		Article a2 = new Article(
				"",
				"Vandalists break down the sets of The Late Show after its last episode aired last night.",
				"", "news3.jpg", featuredArticleAuthor, null);

		Author author3 = new Author("Athyunath R. Eleti/Editor-In-Chief", 0, "");
		Article a3 = new Article(
				"",
				"AINA stages one of its finest acts as crowds throng to watch “Arsenic & Old Lace",
				"", "news5.jpg", author3, null);

		Author author4 = new Author("Subhalakshmi Sarkar/Staff Writer", 0, "");
		Article a4 = new Article(
				"",
				"Farhan Akhtar rocks on at MIT Manipal’s cultural fest Revels’15",
				"", "news6.jpg", author4, null);
		articles = new ArrayList<Article>();
		articles.add(featuredArticle);
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		articles.add(a4);
		articles.add(a3);
		articles.add(a2);
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		articles.add(a4);
	}
}
