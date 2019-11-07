import { h, Component } from 'preact';
import './app.css';
import Markdown from 'preact-markdown';
import 'github-markdown-css';
import Axios from 'axios';
import Helmet from 'preact-helmet';

export default class App extends Component {

	constructor(props){

		super(props)
		this.state={projectInfo:null}
	}

	componentDidMount(){

		var data = "https://gist.githubusercontent.com/Darkhax/37651d8895bbb30c789261238585338e/raw/611342101fe29689cda6b25a5aa96c09556c5438/coins.json";
		Axios.get(data).then((response) => {

			this.setState({projectInfo: response.data});
		}).catch((error) => {

			console.log(error.response);
		});
	}

	render() {

		if (this.state.projectInfo != null) {

			return (
				<div id="app">
					<Helmet
						tile={this.state.projectInfo.project.name}
						meta={[
							{name: "description", content: this.state.projectInfo.project.short_description},
							{name: "twitter:card", content: "summary_large_image"},
							{name: "twitter:creator", content: "@Cubenomenon" },
						    {name: "twitter:title", content: this.state.projectInfo.project.name},
						    {name: "twitter:image", content: this.state.projectInfo.project.header_image_url},
							{name: "twitter:description", content: this.state.projectInfo.project.short_description}
							]}
					/>
					<div className="markdown-body">
						<Markdown markdown={this.state.projectInfo.project.long_description}/>
					</div>
				</div>
			);
		}

		return (
			<div id="app">
				<p>Loading...</p>
			</div>
		);
	}
}