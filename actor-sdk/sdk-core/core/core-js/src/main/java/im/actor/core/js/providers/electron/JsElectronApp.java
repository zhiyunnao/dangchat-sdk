package im.actor.core.js.providers.electron;

public class JsElectronApp {

    public static native boolean isElectron()/*-{
        return  navigator.userAgent.indexOf("Electron") !=-1;
    }-*/;

    public static native void bounce()/*-{
        var ipc = $wnd.requireNode("electron").ipcRenderer;
        ipc.send('tray-bounce');
    }-*/;

    public static native void hideNewMessages()/*-{
        var ipc = $wnd.requireNode("electron").ipcRenderer;
        ipc.send('new-messages-hide');
    }-*/;

    public static native void updateBadge(int count)/*-{
        var ipc = $wnd.requireNode("electron").ipcRenderer;
        ipc.send('tray-badge', { count: count });
    }-*/;


    public static native void subscribe(String topic, JsElectronListener listener)/*-{
        var ipc = $wnd.requireNode("electron").ipcRenderer;
        ipc.on(topic, function(message) {
            listener.@im.actor.core.js.providers.electron.JsElectronListener::onEvent(*)(message);
        });
    }-*/;

    public static native void openUrlExternal(String url)/*-{
        var shell = $wnd.requireNode('electron').shell;
        shell.openExternal(url);
    }-*/;
}