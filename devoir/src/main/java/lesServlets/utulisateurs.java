package lesServlets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class utulisateurs  {
    private static final String USERS_KEY = "users";
    
    static {
        Utulisateur adminUser = new Utulisateur("admin", "Admin", "Administrator", "admin", "admin", "0000000000", "admin");
        addUser(adminUser);
    }


    public static void addUser(Utulisateur utilisateur) {
        @SuppressWarnings("unchecked")
        Map<String, Utulisateur> users = (Map<String, Utulisateur>) Memoire.getValue(USERS_KEY);
        if (users == null) {
            users = new HashMap<>();
        }

        users.put(utilisateur.getId(), utilisateur);

        Memoire.setValue(USERS_KEY, users);
    }
    
    public static Utulisateur getUserById(String userId) {
        @SuppressWarnings("unchecked")
        Map<String, Utulisateur> users = (Map<String, Utulisateur>) Memoire.getValue(USERS_KEY);
        if (users != null) {
            return users.get(userId);
        }
        return null; 
    }

    public static void editUser(Utulisateur updatedUser) {
        @SuppressWarnings("unchecked")
        Map<String, Utulisateur> users = (Map<String, Utulisateur>) Memoire.getValue(USERS_KEY);
        if (users != null && users.containsKey(updatedUser.getId())) {
            users.put(updatedUser.getId(), updatedUser); 
            Memoire.setValue(USERS_KEY, users);
        } else {
            System.out.println("User not found."); // Or handle this case as needed.
        }
    }


    public static List<Utulisateur> getUsers() {
        @SuppressWarnings("unchecked")
        Map<String, Utulisateur> users = (Map<String, Utulisateur>) Memoire.getValue(USERS_KEY);
        if (users == null) {
            return new ArrayList<>(); 
        }
        
        return new ArrayList<>(users.values()); 
    }
    
    
    


}
