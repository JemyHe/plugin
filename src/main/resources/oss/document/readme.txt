阿里云对象存储服务（Object Storage Service，简称OSS）为您提供基于网络的数据存取服务。
使用OSS，您可以通过网络随时存储和调用包括文本、图片、音频和视频等在内的各种非结构化数据文件。

阿里云OSS将数据文件以对象（object）的形式上传到存储空间（bucket）中。您可以进行以下操作：

1.创建一个或者多个存储空间，向每个存储空间中添加一个或多个文件。
2.通过获取已上传文件的地址进行文件的分享和下载。
3.通过修改存储空间或文件的属性或元信息来设置相应的访问权限。
4.可以通过阿里云管理控制台执行基本和高级OSS任务。
5.也可以通过阿里云开发工具包或直接在应用程序中进行RESTful API调用执行基本和高级OSS任务。
6.有关更多信息，请参见阿里云 OSS 开发人员指南。https://help.aliyun.com/document_detail/31827.html?spm=5176.doc31883.2.1.gOxv9c


OSS 术语表

英文	                中文
Bucket	            存储空间
Object	            对象或者文件
Endpoint	        OSS 访问域名
Region	            地域或者数据中心
AccessKey	        AccessKeyId 和 AccessKeySecret 的统称，访问密钥
Put Object	        简单上传
Post Object	        表单上传
Multipart Upload	分片上传
Append Object	    追加上传
Get Object	        简单下载
Callback	        回调
Object Meta	        文件元信息。用来描述文件信息，例如长度，类型等
Data	            文件数据
Key	                文件名
ACL (Access Control List)	存储空间或者文件的权限