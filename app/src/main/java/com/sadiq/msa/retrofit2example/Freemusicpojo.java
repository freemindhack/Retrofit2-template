package com.sadiq.msa.retrofit2example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by muhammadsadiqali on 06/02/16.
 */

    public class Freemusicpojo {

    public String title;
    public List<Dataset> dataset;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public class Dataset {

        protected String curator_title;
        protected String curator_tagline;
        protected String title;
        protected String message;
        protected List<Object> errors = new ArrayList<Object>();
        protected String total;
        protected Integer totalPages;
        protected Integer page;
        protected Integer limit;
        protected List<Dataset> dataset = new ArrayList<Dataset>();
        protected Map<String, Object> additionalProperties = new HashMap<String, Object>();




        /**
         * @return Dataset title
         */
        public String getcurator_tagline() {
            return curator_tagline;
        }

        /**
         * @return Dataset title
         */
        public void setcurator_tagline(String curator_tagline) {
            this.curator_tagline = curator_tagline;
        }

        /**
         * @return Dataset title
         */
        public String getcurator_title() {
            return curator_title;
        }

        /**
         * @return Dataset title
         */
        public void setcurator_title(String curator_title) {
            this.curator_title = curator_title;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The message
         */
        public String getMessage() {
            return message;
        }

        /**
         * @param message The message
         */
        public void setMessage(String message) {
            this.message = message;
        }

        /**
         * @return The errors
         */
        public List<Object> getErrors() {
            return errors;
        }

        /**
         * @param errors The errors
         */
        public void setErrors(List<Object> errors) {
            this.errors = errors;
        }

        /**
         * @return The total
         */
        public String getTotal() {
            return total;
        }

        /**
         * @param total The total
         */
        public void setTotal(String total) {
            this.total = total;
        }

        /**
         * @return The totalPages
         */
        public Integer getTotalPages() {
            return totalPages;
        }

        /**
         * @param totalPages The total_pages
         */
        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        /**
         * @return The page
         */
        public Integer getPage() {
            return page;
        }

        /**
         * @param page The page
         */
        public void setPage(Integer page) {
            this.page = page;
        }

        /**
         * @return The limit
         */
        public Integer getLimit() {
            return limit;
        }

        /**
         * @param limit The limit
         */
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        /**
         * @return The dataset
         */
        public List<Dataset> getDataset() {
            return dataset;
        }

        /**
         * @param dataset The dataset
         */
        public void setDataset(List<Dataset> dataset) {
            this.dataset = dataset;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
    }
    }
