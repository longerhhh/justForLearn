package org.example.stream;

import java.util.Objects;

public class XBean {
    int id;
    String name;
    String age;
    String content;

    @Override
    public String toString() {
        return "XBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public XBean(int id, String name, String age, String content) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XBean xBean = (XBean) o;
        return id == xBean.id && Objects.equals(name, xBean.name) && Objects.equals(age, xBean.age) && Objects.equals(content, xBean.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static XBeanBuilder builder() {
        return new XBeanBuilder();
    }

    public static final class XBeanBuilder {
        private int id;
        private String name;
        private String age;
        private String content;

        private XBeanBuilder() {}

        public static XBeanBuilder aXBean() {return new XBeanBuilder();}

        public XBeanBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public XBeanBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public XBeanBuilder setAge(String age) {
            this.age = age;
            return this;
        }

        public XBeanBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public XBean build() {return new XBean(id, name, age, content);}
    }
}
