var path = require("path");
var CleanWebpackPlugin = require('clean-webpack-plugin');
var MiniCssExtractPlugin = require('mini-css-extract-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var webpack = require('webpack');
var UglifyJSPlugin = require('uglifyjs-webpack-plugin');

var minifyHTML = {
    collapseInlineTagWhitespace: true,
    collapseWhitespace: true,
    minifyJS:true
};

var pathToClean = [
    'main/webapp/*.js',
    'main/webapp/*.map',
    'main/webapp/*.css'
];

var cleanOptions = {
    watch: true,
    verbose: true,
    exclude: ['main/index.jsp']
};

module.exports = {
    mode: 'production',
    devtool: 'source-map',
    entry: { //入口文件
        main: path.resolve(__dirname, 'source/js/main.js')
    },
    plugins: [ // 加载的插件
        new UglifyJSPlugin({
            sourceMap: true
        }),
        new webpack.DefinePlugin({
            'process.env.NODE_ENV': JSON.stringify('production')
        }),
        new CleanWebpackPlugin(pathToClean, cleanOptions),
        new MiniCssExtractPlugin({
            filename: "[name].[chunkhash:8].css",
            //chunkFilename: "[id].css"
        }),
        new HtmlWebpackPlugin({
            inject: false,
            cache: false,
            minify: minifyHTML,
            template: path.resolve(__dirname,'source/script.ejs'),
            filename: path.resolve(__dirname,'main/webapp/WEB-INF/page/_partial/script.jsp')
        }),
        new HtmlWebpackPlugin({
            inject: false,
            cache: false,
            minify: minifyHTML,
            template: path.resolve(__dirname,'source/css.ejs'),
            filename: path.resolve(__dirname,'main/webapp/WEB-INF/page/_partial/css.jsp')
        })
    ],
    output: { // 指定输出选项
        path: path.resolve(__dirname, "main/webapp"), // 指定的文件输出路径
        publicPath: './',
        filename: "[name].[chunkhash:6].js"  // 指定输出的文件名称
    },
    module: { // 第三方loader模块
        rules: [ // 第三方模块匹配规则
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader?cacheDirectory',
                    options: {
                        presets: ['@babel/preset-env'],
                        plugins: ['@babel/transform-runtime']
                    }
                }
            },
            {
                test: /\.(sa|sc|c)ss$/,
                use: [
                    MiniCssExtractPlugin.loader,
                    'css-loader',
                    'postcss-loader',
                    'sass-loader'
                ]
            },
            {
                test: /\.(png|svg|jpg|gif)$/,
                use: {
                    loader: 'url-loader',
                    options: {
                        limit: 8192,
                        fallback: 'file-loader',
                        name: '[name].[ext]',
                        outputPath: 'img/'
                    }
                }
            },
            {
                test: /\.(woff|woff2|eot|otf|ttf)$/,
                use: {
                    loader: 'file-loader',
                    options: {
                        name: '[name].[hash:6].[ext]',
                        outputPath: 'fonts/'
                    }
                }
            }
        ]
    }
};