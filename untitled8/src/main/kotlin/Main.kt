import java.io.File

fun main() {
    val s = """
        Afterpay 上海   先买后付
        Airbnb 北京     公寓短租平台
        Amazon 北京/上海 电子商务 云服务
        AMD 上海        芯片厂
        Apple 北京/上海 苹果 
        ArcSoft 杭州    虹软 计算摄影与计算机视觉技术
        ARM 上海        半导体知识产权（IP）提供商
        Autodesk 北京/上海 设计软件和数字内容创建公司，用于建筑设计、土地资源开发、生产、公用设施、通信、媒体和娱乐
        Booking 上海    缤客 帮您在网上预订世界各地住宿的网站
        Calix 南京      凯易讯网络技术开发  为通讯服务供应商提供一流综合解决方案。
        Canva 北京/武汉 北京咖瓦信息技术有限公司 在线设计平台
        Cisco 北京/上海/杭州/苏州 网络解决方案供应商
        Citrix 南京     思杰  于云计算虚拟化、虚拟桌面和远程接入技术
        Coolapk (酷安) 北京/深圳  酷安网 中文领域的Android应用分发和分享平台
        Coupang 北京/上海  电子商务企业
        CSTC(花旗金融) 上海  花旗金融组织亚太投资有限公司
        Dell 上海  戴尔以生产、设计、销售家用以及办公室电脑而闻名
        Douban (豆瓣) 北京  提供关于书籍、电影、音乐等作品的信息
        Duolingo 北京  多邻国（Duolingo） 是一款语言学习工具软件，其App总下载量逾5亿次
        eBay 上海  在网上买卖物品的线上拍卖及购物网站
        eHealth 厦门  翼华科技  以互联网为平台销售健康保险
        Electronic Arts 上海 EA 主要经营各种电子游戏的开发、出版以及销售业务。
        EMC 上海  美国信息存储资讯科技公司
        EPAM Systems 上海/深圳/苏州/成都  复杂软件工程解决方案和技术服务的领先提供商
        Ericsson 上海   爱立信公司  提供端到端全面通信解决方案
        Flexport 上海/深圳  提供海陆空货运的透明化服务和经过授权的代理经纪人服务。
        FreeWheel 北京  提供互联网视频广告投放、监测、预测、增值等关键解决方案
        GE 上海  提供技术和服务业务
        Google 北京/上海    业务包括互联网搜索、云计算、广告技术等
        Grab 北京    供包括网约车、送餐、酒店预订、网上银行、移动支付和保险服务
        Honeywell 上海  霍尼韦尔  航空产品和服务、楼宇、家庭和工业控制技术、汽车产品、涡轮增压器以及特殊材料
        HP 上海  
        HSBC 上海/广州/西安  汇丰银行是外资银行，
        Hulu 北京  hulu是美国的一个视频网站
        IBM (GBS除外） 北京/上海   信息技术和业务解决方案
        iHerb 上海  艾贺博网路公司  保健产品专营线上零售商
        Intel 北京/上海/深圳  
        LeetCode 上海  **领扣网络旗下专注于程序员技术成长和企业技术人才服务的品牌**
        LEGO Group 上海   华纳兄弟互动娱乐公司、TT Games和LEGO Group共同公开了《乐高》系列的游戏新作《乐高侏罗纪世界(LEGO Jurassic World)》
        Linkedin 北京 是一个面向职场的社交平台
        Micro Focus 上海 上海微福思软件科技有限公司 在DevOps、混合IT、安全和风险管理、预测性分析等关键领域提供解决方案。
        Microsoft 北京/上海/苏州  美国跨国科技企业  最为著名和畅销的产品为Windows操作系统和Office系列软件，是全球最大的电脑软件提供商、世界PC（Personal Computer，个人计算机）软件开发的先导。
        MicroStrategy 杭州  微策略(Microstrategy)  BI（商业智慧或商务智能，指用现代数据仓库技术、线上分析处理技术、数据挖掘和数据展现技术进行数据分析以实现商业价值）工具和服务厂家。
        Morgan Stanley (IT) 上海  摩根士丹利  提供包括证券、资产管理、企业合并重组和信用卡等多种金融服务，
        National Instruments 上海  视觉软件产品，实现机器视觉应用
        Nike 上海   体育运动品牌  耐克商标图案是个小钩子
        Nokia 上海/南京/杭州  主营移动通信设备生产和相关服务的跨国公司
        Nomura 上海  野村证券  日本大券商  
        NVIDIA 北京/上海
        Optiver 上海  **Optiver上海不是IT外包性质的，也没有任何外包的IT部门。上海optiver基本是个完整独立的办公室。顶级对冲基金optiver急招**
        Oracle 上海  Oracle公司（甲骨文）是全球最大的信息管理软件及服务供应商
        PayPal 上海  是一个总部在美国加利福尼亚州圣荷塞市的在线支付服务商。
        Philips 上海/苏州  主要生产照明、家庭电器、医疗系统方面的产品
        Pivotal 北京/上海  Pivotal主导的Greenplum数据库，HDB (SQL on Hadoop)以及Cloud Foundry等知名产品的开源。  为企业级“平台即服务(PaaS)“和”大数据基础架构“设定标准，帮助行业企业向数字经济转型
        Qualcomm 北京/上海
        Rakuten 上海/大连  乐天株式会社（Rakuten)，  日本最大电子商店街“乐天市场”经营者
        Red Hat 北京/上海/深圳/西安/remote  红帽公司为诸多重要IT技术如操作系统、存储、中间件、虚拟化和云计算提供关键任务的软件与服务。
        RingCentral 厦门/杭州/香港  基于其Message Video Phone ™   (MVP ™ ) 全球平台的云商务通信和联络中心解决方案的供应商。
        Rippling 北京/上海  该公司开发的软件统筹管理员工薪酬福利、硬件及应用，确保新员工入职顺利，帮助中小公司化简行政工作，节约时间。
        SanDisk 上海   是全球最大的闪速数据存储卡产品供应商
        SAP 上海  SAP SE（Systems, Applications & Products in Data Processing）是德国的一家软件公司。 是全球最大的企业管理和协同化商务解决方案供应商  
        SmartNews 北京/上海  SmartNews is the award-winning news app loved by millions. We are a machine-learning company deeply committed to helping users find quality news beyond the filter bubble.
        Snap 北京/深圳  Snap公司拥有著名社交应用Snapchat，旗下Spectacles太阳镜产品初代，在2016年推出后曾一度畅销。
        State Street 杭州   美国道富银行(State Street Corp)  现为全球最大的托管银行和最大的资产管理公司之一
        SUSE 北京/上海/深圳  SUSE已成为全球最大的独立开源软件商业公司
        The Trade Desk 上海/深圳  The Trade Desk，是美国广告科技公司（TTD.US）。 
        ThoughtWorks 西安/北京/深圳/成都/武汉/上海/香港  全球性软件及咨询公司  针对全球客户数字化业务提供专业组织转型咨询、创新软件交付、用户体验设计、产品及一体化解决方案等服务。
        Trend Micro 南京  趋势科技——网络安全软件及服务领域的全球领导者  
        Tubi 北京  Tubi 是美国福克斯集团下独立运营、以广告获取收益的免费流媒体服务公司,通过广告获取收益,实现用户、内容提供商和广告主共赢。
        TuSimple 北京/上海  图森未来（TuSimple）是一个无人驾驶卡车品牌  创立初衷在于以L4级别（SAE标准）的无人驾驶卡车技术为全球物流运输行业赋能。
        Two Sigma 上海  Two Sigma由计算机科学家、数学家，David Siegel 和John Overdeck联合创立，最新管理规模超过600亿美元。它与文艺复兴科技、Citadel、千禧年等为华尔街最具影响力的科学投资、系统化投资巨头。
        Ubisoft 上海  育碧娱乐软件公司(Ubisoft Entertainment)是一家跨国的游戏制作、发行和代销商。
        Unity 上海  Unity [1]  是实时3D互动内容创作和运营平台 [2]  。包括游戏开发、美术、建筑、汽车设计、影视在内的所有创作者，借助Unity将创意变成现实。
        Vipshop(唯品会) 上海  唯品会主营业务为互联网在线销售品牌折扣商品，涵盖名品服饰鞋包、美妆、母婴、居家等各大品类。
        VMware 北京/上海  是全球云基础架构和移动商务解决方案厂商，提供基于VMware的解决方案，企业通过数据中心改造和公有云整合业务，借助企业安全转型维系客户信任 [3]  ，实现任意云端和设备上运行、管理、连接及保护任意应用。
        WeWork 上海  wework是共用工作空间运营模式的公司,其旗下主要业务是为初创公司、微商企业、自由职业企业家提供办公场所,总部位于美国纽约。
        Wish 上海   Wish是北美和欧洲最大的移动电商平台,有90%的卖家来自中国,是一家位于硅谷的高科技独角兽公司。 
        Works Applications 上海  Works Applications（上海万革始应用软件有限公司） 公司主营业务是“适用于大型企业，机关的ERP软件系统的开发，销售及售后服务”
        XMind 深圳   Xmind是风靡全球的头脑风暴和思维导图软件,为激发灵感和创意而生。
        Zhihu(知乎) 北京  中文互联网高质量的问答社区和创作者聚集的原创内容平台
        Zoom 合肥/杭州/苏州  zoom公司创立于日本，起初生产录音设备，生产包括吉他效果器，贝斯效果器等现代化音乐外设以及录音产品。 Zoom 致力于帮助广大企业和组织打造无障碍的沟通环境，提升工作效率。 我们的视频、语音、内容共享和聊天云平台上手简单、安全可靠，可以跨移动设备、桌面、电话和会议室系统运行。 
    """.trimIndent()
//    File("out.csv").outputStream().use { it.bufferedWriter().use { it.append(s.replace(" ", ",")).flush() } }
    File("shanghai.txt").outputStream().use { it.bufferedWriter().use { it.append(s.split("\n").filter { it.contains("上海") }.joinToString(separator = "\n") {
        it
    })}}
}
