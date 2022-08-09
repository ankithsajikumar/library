const path = require('path');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const FixStyleOnlyEntriesPlugin = require("webpack-fix-style-only-entries");
const STATIC_PATH = __dirname + '../../src/main/resources';

module.exports = {
	mode: "development",
    entry: {
		style: __dirname + '/src/scss/main.scss',
		script: __dirname + '/src/js/main.js'
	},
    output: {
        filename: 'js/[name].js',
        path: path.resolve(STATIC_PATH, 'static/dist')
    },
    module: {
        rules: [{
            test: /\.scss$/,
            use: [
                MiniCssExtractPlugin.loader,
                'css-loader',
                'sass-loader'
            ]
		}]
	},
	plugins: [
        new CleanWebpackPlugin(),
        new FixStyleOnlyEntriesPlugin(),
        new MiniCssExtractPlugin({
            filename: 'css/[name].css'
        })
    ]
}
