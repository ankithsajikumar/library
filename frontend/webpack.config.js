const path = require('path');
const webpack = require('webpack');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const CssMinimizerPlugin = require("css-minimizer-webpack-plugin");
const TerserPlugin = require("terser-webpack-plugin");
const FixStyleOnlyEntriesPlugin = require("webpack-fix-style-only-entries");
const STATIC_PATH = __dirname + '../../src/main/resources';

module.exports = {
	mode: "production",
    entry: {
		style: __dirname + '/src/scss/main.scss',
		script: __dirname + '/src/js/main.js'
	},
    output: {
        filename: 'js/[name].js',
        path: path.resolve(STATIC_PATH, 'static')
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
	optimization: {
		minimize: true,
        minimizer: [
          new CssMinimizerPlugin(),
          new TerserPlugin()
        ]
	},
	plugins: [
        new CleanWebpackPlugin(),
        new FixStyleOnlyEntriesPlugin(),
        new MiniCssExtractPlugin({
            filename: 'css/[name].css'
        }),
        new webpack.ProvidePlugin({
			$: 'jquery',
			jQuery: 'jquery',
        })
    ]
}
