package com.vimoautomations.newsapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.vimoautomations.newsapp.R;
import com.vimoautomations.newsapp.ui.models.Article;
import com.vimoautomations.newsapp.ui.models.News;
import com.vimoautomations.newsapp.ui.util.DiffArticlesCallBack;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {

    DiffArticlesCallBack callBack = new DiffArticlesCallBack();
    AsyncListDiffer<Article> differ = new AsyncListDiffer<>(this, callBack);
    Context mContext;
    public NewsAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public NewsAdapter.ArticleViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article_preview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ArticleViewHolder holder, int position) {
        Article article = differ.getCurrentList().get(position);
//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher_round)
//                .error(R.mipmap.ic_launcher_round);

        Glide.with(mContext).load(article.urlToImage)
                .into(holder.ivArticleImage);
//        RequestManager manager = Glide.with(holder.ivArticleImage);
//        manager.load(article.urlToImage).into(holder.ivArticleImage);
        holder.tvSource.setText(article.source.name);
        holder.tvTitle.setText(article.title);
        holder.tvDescription.setText(article.description);
        holder.tvPublishedAt.setText(article.publishedAt.toString());

        //        .into(holder.ivArticleImage);
        //holder.itemView = Glide.with(holder.itemView.getContext()).load(article.urlToImage).apply(options).into(holder.ivArticleImage);
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {
        ImageView ivArticleImage = itemView.findViewById(R.id.ivArticleImage);
        TextView tvSource = itemView.findViewById(R.id.tvSource);
        TextView tvTitle = itemView.findViewById(R.id.tvTitle);
        TextView tvDescription = itemView.findViewById(R.id.tvDescription);
        TextView tvPublishedAt = itemView.findViewById(R.id.tvPublishedAt);

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //itemView.setOnClickListener();
        }
    }
}
