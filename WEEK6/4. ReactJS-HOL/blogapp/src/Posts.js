import React from "react";
import Post from "./Post";
class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false,
        };
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then((response) => response.json())
            .then((data) => {
                const postsArray = data.map(
                    (item) => new Post(item.id, item.title, item.body)
                );
                this.setState({ posts: postsArray });
            })
            .catch((error) => {
                console.error("Error fetching posts:", error);
                this.setState({ hasError: true });
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert("An error occurred in the Posts component.");
        console.error("Error:", error);
        console.error("Info:", info);
    }

    render() {
        const { posts, hasError } = this.state;

        if (hasError) {
            return <h2>Something went wrong while loading posts.</h2>;
        }

        return (
            <div>
                <h1>Blog Posts</h1>
                {posts.map((post) => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                        <hr />
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
