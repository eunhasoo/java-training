import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    class Document {
        int id, importance;

        public Document(int id, int importance) {
            this.id = id;
            this.importance = importance;
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        while (t-- > 0) {
            ArrayDeque<Document> queue = new ArrayDeque<>();
            List<Integer> importanceList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 찾고자 하는 문서 id

            // 입력받은 순서대로 큐에 문서를 넣고 우선순위 리스트에도 값을 추가한다
            st = new StringTokenizer(reader.readLine());
            for (int id = 0; id < n; id++) {
                int importance = Integer.parseInt(st.nextToken());
                importanceList.add(importance);
                queue.add(new Document(id, importance));
            }

            // 우선순위가 높은 순서를 비교하기 위해 정렬한다
            Collections.sort(importanceList, Collections.reverseOrder());

            // 큐에 있는 문서를 우선순위를 비교한 뒤 출력하거나 맨뒤로 보낸다
            int idx = 0;
            while (!queue.isEmpty()) {
                Document document = queue.remove();

                if (document.importance < importanceList.get(idx)) {
                    queue.add(document);
                    continue;
                }

                if (document.id == m) {
                    builder.append(idx + 1).append("\n");
                    break;
                }

                idx++;
            }
        }

        System.out.print(builder);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
