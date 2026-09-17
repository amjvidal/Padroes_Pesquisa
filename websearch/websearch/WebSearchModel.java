import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Perform "web search" (from a file), notify the interested observers of each
 * query.
 */
public class WebSearchModel {
    private final File sourceFile;
    private final List<ObserverRegistration> observers = new ArrayList<>();

    public interface QueryObserver {
        void onQuery(String query);
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void addQueryObserver(QueryObserver queryObserver) {
    addQueryObserver(queryObserver, null);
}

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                notifyAllObservers(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void notifyAllObservers(String line) {
        for (ObserverRegistration reg : observers) {
            if (reg.filter == null || reg.filter.accepts(line)){
                reg.observer.onQuery(line);
            }
        }
    }

    private class ObserverRegistration {
        QueryObserver observer;
        QueryFilter filter;

        ObserverRegistration(QueryObserver observer, QueryFilter filter) {
            this.observer = observer;
            this.filter = filter;
        }
    }

    public void addQueryObserver(QueryObserver queryObserver, QueryFilter filter) {
        observers.add(new ObserverRegistration(queryObserver, filter));
    }
}
