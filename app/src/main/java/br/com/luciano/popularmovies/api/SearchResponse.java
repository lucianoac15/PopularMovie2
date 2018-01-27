package br.com.luciano.popularmovies.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse<T> {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<T> results;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private long totalResults;

    public SearchResponse(int page, List<T> results, int totalPages, long totalResults) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public int getPage() {
        return page;
    }

    public List<T> getResults() {
        return results;
    }



}
