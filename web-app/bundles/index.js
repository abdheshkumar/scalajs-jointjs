window.jQuery = require('jquery');
require('lodash');
require('backbone');
window.joint = require("jointjs");
window.V = window.joint.V;
window.ReactDOM = require('react-dom');
window.React = require('react');
window.mui = require("material-ui");
window.mui.Styles = require("material-ui/styles");

window.mui.SvgIcons = require('material-ui/svg-icons');

window.bootstrap = require('bootstrap/dist/css/bootstrap.min.css');

window.bsVars = require('less-vars-loader?camelCase,resolveVariables!bootstrap/less/variables.less');

var injectTapEventPlugin = require('react-tap-event-plugin');
injectTapEventPlugin();