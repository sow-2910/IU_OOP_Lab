interface TextScreen {
    void showText(String text);
}

interface InteractiveScreen {
    void handleUserInput(String input);
}

interface MediaScreen {
    void showImage(String path);

    void playVideo(String path);
}

class LoginScreen implements TextScreen, InteractiveScreen {
    @Override
    public void showText(String text) {
        System.out.println("LOGIN: " + text);
    }

    @Override
    public void handleUserInput(String input) {
        System.out.println("Handling login input: " + input);
    }
}

class TutorialScreen implements MediaScreen {
    public void showImage(String path) {
        System.out.println("Displaying image from path: " + path);
    }

    public void playVideo(String path) {
        System.out.println("Displaying video from path: " + path);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
