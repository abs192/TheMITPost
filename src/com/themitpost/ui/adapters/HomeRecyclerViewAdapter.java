package com.themitpost.ui.adapters;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.themitpost.R;
import com.themitpost.data.Article;
import com.themitpost.utils.Radio;

public class HomeRecyclerViewAdapter extends
		RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

	public static final int VIEWTYPE_FEATURED = 0x2312;
	public static final int VIEWTYPE_NORMAL = 0x2313;

	private List<Article> articles = new ArrayList<Article>();

	public static class ViewHolder extends RecyclerView.ViewHolder {

		TextView mTextViewTitle, mTextViewBody, mTextViewAuthor;
		ImageView mImageView;

		public ViewHolder(View v) {
			super(v);
			mTextViewTitle = (TextView) v.findViewById(R.id.textViewTitle);
			mTextViewBody = (TextView) v.findViewById(R.id.textViewBody);
			mTextViewAuthor = (TextView) v.findViewById(R.id.textViewAuthor);
			mImageView = (ImageView) v.findViewById(R.id.imageView);
		}

		public void setData(Article article) {
			if (article != null) {

				if (article.isFeatured())
					mTextViewTitle.setText(article.getTitle());
				mTextViewBody.setText(article.getBody());
				mTextViewAuthor.setText("| " + article.getAuthor().getName());
				// fetch image cache Radio. cachedfetch..
				Radio.fetchImage(mImageView, article.getImageUrl(),
						article.isFeatured(), false);
			}
		}

		public String truncate(String a) {
			return a.substring(0, 30) + "...";
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public HomeRecyclerViewAdapter(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public HomeRecyclerViewAdapter.ViewHolder onCreateViewHolder(
			ViewGroup parent, int viewType) {
		// create a new view
		int layout;
		if (viewType == VIEWTYPE_FEATURED)
			layout = R.layout.home_featured_article;

		else
			layout = R.layout.home_single_article;
		View v = LayoutInflater.from(parent.getContext()).inflate(layout,
				parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		if (articles != null) {
			holder.setData(articles.get(position));
		}
	}

	@Override
	public int getItemViewType(int position) {
		return position == 0 ? VIEWTYPE_FEATURED : VIEWTYPE_NORMAL;
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return articles.size();
	}
}