public class Character {
    private ArrayList<String> features;

    public Character(String name, int gold) {
        ……
        this.features = new ArrayList<>();
    }

    public void addFeature(String feature) {
        features.add(feature);
        System.out.println(feature + " added to " + name + "'s inventory.");
    }

    public void removeFeature(String feature) {
        if (features.contains(feature)) {
            inventory.remove(feature);
            System.out.println(feature + " removed from " + name + "'s inventory.");
        } else {
            System.out.println(feature + " not found in " + name + "'s inventory.");
        }
    }
