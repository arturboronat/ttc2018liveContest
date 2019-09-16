package ttc2018;

import org.neo4j.graphdb.Result;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public enum Query {
    Q1_BATCH(Paths.get("q1.cypher")),
    Q1_INITIAL(Paths.get("q1-initial.cypher")),
    Q1_RETRIEVE(Paths.get("q1-retrieve.cypher")),

    Q2_BATCH(Paths.get("q2.cypher")),
    Q2_BATCH_ALGO(Paths.get("q2-algo.cypher")),
    Q2_BATCH_ALGO_WITH_FILTERED_EDGES(Paths.get("q2-algo-with-filtered-edges.cypher")),
    Q2_INITIAL_OVERLAY_GRAPH(Paths.get("q2-initial-overlay-graph.cypher")),
    Q2_INITIAL_DYNAMIC_LIKES_LABELS(Paths.get("q2-initial-dynamic-likes-labels.cypher")),
    Q2_DELETE_OVERLAY_GRAPH(Paths.get("q2-delete-overlay-graph.cypher")),
    Q2_INITIAL_SCORE(Paths.get("q2-initial-score.cypher")),
    Q2_INITIAL_COMPONENTS_AND_SCORE(Paths.get("q2-initial-components-and-score.cypher")),
    Q2_INITIAL_COMPONENTS_PERIODIC(Paths.get("q2-initial-components_periodic.cypher")),
    Q2_INITIAL_SCORE_FROM_EXPLICIT_COMPONENTS(Paths.get("q2-initial-score-from-explicit-components.cypher")),
    Q2_INITIAL_ZERO_SCORE(Paths.get("q2-initial-zero-score.cypher")),
    Q2_UPDATE_OVERLAY_GRAPH_FRIEND_EDGE(Paths.get("q2-update-overlay-graph-friend-edge.cypher")),
    Q2_UPDATE_OVERLAY_GRAPH_LIKES_EDGE(Paths.get("q2-update-overlay-graph-likes-edge.cypher")),
    Q2_MERGE_COMPONENTS_AFTER_FRIEND_EDGE(Paths.get("q2-merge-components-after-friend-edge.cypher")),
    Q2_MERGE_COMPONENTS_AFTER_LIKES_EDGE(Paths.get("q2-merge-components-after-likes-edge.cypher")),
    Q2_RECALCULATE_SCORE(Paths.get("q2-recalculate-score.cypher")),
    Q2_RETRIEVE(Paths.get("q2-retrieve.cypher")),
    ;

    public static final String ID_COLUMN_NAME = "id";
    public static final String SCORE_COLUMN_NAME = "score";

    public final String queryText;

    Query(Path f) {
        try {
            queryText = new String(Files.readAllBytes(f));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Query(String s) {
        queryText = s;
    }

    public Result execute(Solution solution, Map<String, Object> parameters) {
        return solution.getDbConnection().execute(queryText, parameters);
    }
}
