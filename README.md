# CompleteImageView
一个用于Android的大图查看器

## 如何快速开始使用

### 第一步，你需要创建一个图片下载器。
假如你想使用Glide下载图片，就可以像下面这样写：

    public class FileDownLoader implements ImageDownloader {
        @Override
        public File downLoad(String url, Activity activity) {
            File file = null;
            try {
                file = Glide.with(activity).load(url).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return file;
        }
    }

总之就是新建一个类，实现ImageDownloader接口，并实现其中的downLoad方法，返回你在方法中下载的图片就行了。

### 第二步，创建一个CompleteImageView对象。

    CompleteImageView completeImageView = new CompleteImageView(activity, new FileDownLoader());
构造方法传入两个参数，activity和FileDownLoader。其中activity充当Context的作用。

### 第三步，传入要显示的图片资源

如果你想查看的是网络图片，则请这样写：

    completeImageView.setUrls(urls, 0);
urls的类型是List<String>, 而0表示的是要查看的位置，0表示从第一张开始看。再举个例子，假如你想查看5张图片，但是你想从第三张看起，这里应该传入2.

如果你想查看的是本地图片，你应该这样写：

    completeImageView.setFiles(files, 0);
    completeImageView.setOnDeleteItemListener(position -> {
                
                });
files的类型是List<File>,0的意思同上。如果你想查看本地图片，请获取到它的File对象。
由于查看本地图片的时候，提供了一个移除图片的功能，因此，您可以通过添加删除监听，用来在用户移除图片的时候做一些别的事情。

### 第四步，创建

    completeImageView.create();
这样就可以启动并显示了。
