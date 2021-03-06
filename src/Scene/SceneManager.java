package Scene;

public class SceneManager {

    public static SceneManager instance = new SceneManager();

    private Scene currentScene;
    private Scene nextScene;

    private SceneManager() {

    }

    public void changeScene(Scene scene) {
        this.nextScene = scene;
    }

    public void performChangeSceneIfNeeded() {
        if (this.nextScene == null) return;
        if (this.currentScene != null) this.currentScene.deinit();
        this.nextScene.init();
        this.currentScene = this.nextScene;
        this.nextScene = null;
    }

    public Scene getCurrentScene() {
        if (currentScene != null)
        return this.currentScene;
        return null;
    }

}
