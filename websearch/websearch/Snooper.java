/**
 * Watches the search queries
 */
public class Snooper {
    public final WebSearchModel model;

    public Snooper(WebSearchModel model) {
        this.model = model;

        model.addQueryObserver(
                new WebSearchModel.QueryObserver() {
                    @Override
                    public void onQuery(String query) {
                        System.out.println("Oh Yes! " + query);
                    }
                },
                new QueryFilter() {
                    @Override
                    public boolean accepts(String query) {
                        return query.toLowerCase().contains("friend");
                    }
                });

        model.addQueryObserver(
                new WebSearchModel.QueryObserver() {
                    @Override
                    public void onQuery(String query) {
                        System.out.println("So long........ " + query);
                    }
                },

                new QueryFilter() {
                    @Override
                    public boolean accepts(String query) {
                        return query.length() > 60;
                    }
                });
    }
}
