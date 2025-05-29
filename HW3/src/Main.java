import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Kullanıcı listesi
        ArrayList<User> users = new ArrayList<>();

        // Gönderiler: Key = kullanıcı adı, Value = gönderi listesi
        HashMap<String, LinkedList<Post>> allPostsMap = new HashMap<>();

        // Örnek kullanıcılar
        User alice = new User("alice", "alice@example.com", 20, "Hello!", "alice.png");
        User bob = new User("bob", "bob@example.com", 25, "Coder", "bob.jpg");
        User charlie = new User("charlie", "charlie@example.com", 17, "Student", "charlie.jpg");

        users.add(alice);
        users.add(bob);
        users.add(charlie);

        // Arkadaş ekleme
        alice.addFriend(bob);
        bob.addFriend(alice);
        charlie.addFriend(alice);

        // Gönderi ekleme
        Post post1 = new Post("Alice's first post");
        Post post2 = new Post("Bob shares a photo");
        Post post3 = new Post("Charlie loves Java");

        alice.addPost(post1);
        bob.addPost(post2);
        charlie.addPost(post3);

        post1.like("bob");
        post1.like("charlie");
        post2.like("alice");

        // HashMap’e gönderileri ekleyelim
        for (User u : users) {
            allPostsMap.put(u.getUsername(), u.getPosts());
        }

        // Takipçi sıralaması (Beğeni sayısına göre)
        TreeMap<Integer, List<String>> popularityMap = new TreeMap<>(Collections.reverseOrder());

        for (User u : users) {
            // Kullanıcının toplam beğeni sayısını hesapla
            int totalLikes = u.getPosts()
                    .stream()
                    .mapToInt(Post::getLikeCount)
                    .sum();

            // TreeMap içinde o beğeni sayısı varsa listeye ekle, yoksa yeni liste oluştur
            popularityMap.computeIfAbsent(totalLikes, k -> new ArrayList<>()).add(u.getUsername());
        }

        System.out.println("\nEn Popüler Kullanıcı(lar):");
        Map.Entry<Integer, List<String>> mostPopularEntry = popularityMap.firstEntry();
        System.out.println("Toplam Beğeni: " + mostPopularEntry.getKey());
        System.out.println("Kullanıcılar: " + mostPopularEntry.getValue());

        // Iterator ile kullanıcıları ve gönderileri listele
        System.out.println("\n--- Tüm Kullanıcılar ve Gönderiler ---");
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User u = userIterator.next();
            System.out.println("Kullanıcı: " + u.getUsername());
            for (Post p : u.getPosts()) {
                System.out.println("   Gönderi: " + p.getContent() + " | Beğeni: " + p.getLikeCount());
            }
        }

        // BONUS: 18 yaş altı kullanıcıları anonim sınıfla filtrele
        System.out.println("\n--- 18 Yaş Altı Kullanıcılar ---");
        users.stream().filter(new java.util.function.Predicate<User>() {
            @Override
            public boolean test(User u) {
                return u.getUsername() != null && u.getAge() < 18;
            }
        }).forEach(u -> System.out.println(u.getUsername()));

        // BONUS: Belirli Kelimeyi İçeren Gönderileri Bulma
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAranacak kelimeyi girin: ");
        String keyword = scanner.nextLine().toLowerCase();

        // Eşleşen gönderileri tutacak liste
        List<Post> matchingPosts = new ArrayList<>();

        System.out.println("\n--- \"" + keyword + "\" kelimesini içeren gönderiler ---");

        for (User u : users) {
            u.getPosts().stream()
                    .filter(new Predicate<Post>() {
                        @Override
                        public boolean test(Post p) {
                            return p.getContent() != null && p.getContent().toLowerCase().contains(keyword);
                        }
                    })
                    .forEach(p -> {
                        System.out.println("Kullanıcı: " + u.getUsername());
                        System.out.println("→ Gönderi: " + p.getContent());
                        System.out.println();

                        // Listeye ekle
                        matchingPosts.add(p);
                    });
        }

        System.out.println("Toplam eşleşen gönderi sayısı: " + matchingPosts.size());
    }
}